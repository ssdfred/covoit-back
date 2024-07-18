package covoit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import covoit.entities.Route;
import covoit.repository.RouteRepository;

@Service
public class RouteService {
	@Autowired
	private RouteRepository routeRepository;
	
	public List<Route> getRoutes() {
		return (List<Route>) routeRepository.findAll();
	}
}
