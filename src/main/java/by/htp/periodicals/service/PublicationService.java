package by.htp.periodicals.service;

import java.util.List;

import by.htp.periodicals.domain.Publication;

public interface PublicationService {
	
	List<Publication> readAll();
	
	Publication read(int id);

}
