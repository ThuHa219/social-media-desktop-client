package edu.hanu.social_media_desktop_client.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import edu.hanu.social_media_desktop_client.dao.ProfileDAO;
import edu.hanu.social_media_desktop_client.exception.DataNotFoundException;
import edu.hanu.social_media_desktop_client.model.Profile;
import edu.hanu.social_media_desktop_client.utils.PasswordAuthentication;

public class ProfileService {
	private ProfileDAO dao = new ProfileDAO();
	PasswordAuthentication authentication = new PasswordAuthentication();

	public ProfileService() {
		// do nothing
	}

	public List<Profile> getAllProfiles() {
		return dao.getAll();
	}

	public Profile getProfile(String profilename) throws DataNotFoundException {
		Profile profile = dao.get(profilename);
		if (profile == null) {
			throw new DataNotFoundException("Can not found profile with profile name: " + profilename);
		}
		return profile;
	}

	public List<Profile> getProfilesForYear(int year) {
		List<Profile> profilesYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Profile p : dao.getAll()) {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
			Date date = null;
			try {
				date = formatter.parse(p.getCreated());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cal.setTime(date);
			if (cal.get(Calendar.YEAR) == year) {
				profilesYear.add(p);
			}
		}
		return profilesYear;
	}

	public List<Profile> getProfilesPaginated(int start, int size) {
		List<Profile> list = dao.getAll();
		if (start + size > list.size()) {
			return new ArrayList<>();
		}
		return list.subList(start, start + size);
	}

	public Profile addProfile(Profile profile) {
		dao.save(profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		dao.update(profile);
		return profile;
	}

	public Profile editProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		dao.edit(profile);
		return profile;
	}

	public void removeProfile(String profileName) throws DataNotFoundException {
		Profile profile = dao.get(profileName);
		if (profile == null) {
			throw new DataNotFoundException("Can not found profile with profile name: " + profileName);
		}
		dao.delete(profileName);
	}

	@SuppressWarnings({ "static-access", "deprecation" })
	public boolean checkAuthetication(String name, String pass) {
		List<Profile> profiles = dao.getAll();
		List<Profile> result = profiles.stream().filter(profile -> profile.getProfileName().equals(name))
				.collect(Collectors.toList());
		boolean check = false;
		if (result == null) {
			check = false;
		} else {
			for (Profile profile : result) {
				if (authentication.checkPassword(pass, profile.getPassword()) == true) {
					check = true;
				} else {
					check = false;
				}
			}
		}
		return check;
	}
}
