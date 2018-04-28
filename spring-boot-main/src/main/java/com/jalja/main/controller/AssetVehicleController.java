package com.jalja.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jalja.main.model.JaljaUser;
import com.jalja.main.service.AssetVehicleService;

@RestController
@RequestMapping(value="/asset")
public class AssetVehicleController {
	@Autowired
	private AssetVehicleService assetVehicleService;
	
	@GetMapping("/getListById")
	public List<JaljaUser> getListById(Long id) {
		return assetVehicleService.getListById(id);
	}

}
