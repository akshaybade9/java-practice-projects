package com.spring.security;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
@EnableMethodSecurity
public class RoomController {
	
	
	@PostMapping
	//@PreAuthorize("hasRole('ADMIN')")
	@PreAuthorize("hasAuthority('ROOM_ADD')")
	public String addRoom() {
		return "Room added";
	}
	
	@GetMapping("/{id}")
	//@PreAuthorize("hasAnyRole('ADMIN','USER','STAFF')")
	@PreAuthorize("hasAnyAuthority('ROOM_VIEW')")
	@PostAuthorize("returnObject.username==authentication.name")
	public Room getRoomById(@PathVariable Long id, @RequestParam String username) {
		Room room = new Room();
		room.setId(id);
		room.setUsername(username);
		return room;
	}
	
	@GetMapping
	//@PreAuthorize("hasAnyRole('ADMIN','STAFF')")
	@PreAuthorize("hasAnyAuthority('ROOM_VIEW_ALL')")
	public String getRooms() {
		return "All Rooms";
	}

}
