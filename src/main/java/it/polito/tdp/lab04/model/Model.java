package it.polito.tdp.lab04.model;

import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO c= new CorsoDAO(); 
	StudenteDAO s= new StudenteDAO(); 
	
	public List<Corso> getCorsi(){
		return c.getTuttiICorsi(); 
	}
	
	public List<Studente> getStudenti(int matricola){
		return s.getStudenti(matricola);
	}
	
	public List<Studente> getStudentiCorsi (String codins){
		return s.getStudentiCorsi(codins); 
	}

}
