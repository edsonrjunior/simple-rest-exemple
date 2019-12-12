package fiap.scj34.rest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fiap.scj34.rest.model.Vehicle;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	private static final List<Vehicle> LISTVEHICLES = new ArrayList<Vehicle>();

	static {
		LISTVEHICLES.add(new Vehicle(1, "Honda", "Civic", "FBI-8003", 2009, "Grey"));
		LISTVEHICLES.add(new Vehicle(2, "Toyota", "Corolla", "FXB-8015", 2017, "White"));
	}

	@GetMapping
	public List<Vehicle> getAllVehicle() {
		return LISTVEHICLES;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vehicle> getVehicleById(@PathVariable(value = "id") Integer id) {
		for (Vehicle vehicle : LISTVEHICLES) {
			if (id.equals(vehicle.getId())) {
				return ResponseEntity.ok(vehicle);
			}
		}
		return ResponseEntity.notFound().build();
	}

	public void saveVehicle(Vehicle veichle) {

	}
//	
//	public Vehicle updateVehicle (Integer id, Vehicle vehicle) {
//		
//	}
//	
//	public void deleteVehicle(Integer id) {
//		
//	}

}
