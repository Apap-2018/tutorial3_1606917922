package com.apap.tutorial3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.apap.tutorial3.model.PilotModel;

@Service
public class PilotInMemoryService implements PilotService{
	private List<PilotModel> archivePilot;
	
	public PilotInMemoryService() {
		archivePilot = new ArrayList<>();
	}
	
	public void addPilot(PilotModel pilot) {
		archivePilot.add(pilot);	
	}

	public List<PilotModel> getPilotList() {
		return archivePilot;
	}

	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		for (int i=0; i<archivePilot.size(); i++) {
			if(archivePilot.get(i).getLicenseNumber().equals(licenseNumber)) {
				return archivePilot.get(i);
			}
		}
		return null;
	}

	@Override
	public PilotModel getPilotDetailById(String id) {
		for (int i=0; i<archivePilot.size(); i++) {
			if(archivePilot.get(i).getId().equalsIgnoreCase(id)) {
				return archivePilot.get(i);
			}
		}
		return null;
	}

	@Override
	public void deletePilot(PilotModel pilot) {
		archivePilot.remove(pilot);
	}

}
