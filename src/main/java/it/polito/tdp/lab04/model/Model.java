package it.polito.tdp.lab04.model;

import java.util.LinkedList;
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

	public List<Corso> getCorsiStudente(Studente st){
		return c.getCorsiStudente(st);
	}
	
	public String isIscritto (String cor, int mat) {
		
	 List <Studente> sIsc= new LinkedList<Studente>(s.getStudentiCorsi(cor));
	 //la lista sIsc contiene tutti gli iscritti al corso 
	 
	 for (Studente stu: sIsc) {
		if(stu.getMatricola()==mat) {
			return "Studente già iscritto al corso"; 
		}
	}
		return "Studente non iscritto al corso";
	}
	
	public String Iscrivi (Studente stu, String cor)
	{
		boolean r=c.inscriviStudenteACorso(stu, cor);
		if (r==true)
			return "Utente iscritto";
		return "Impossibile iscrivere l'utente";
	}
}
