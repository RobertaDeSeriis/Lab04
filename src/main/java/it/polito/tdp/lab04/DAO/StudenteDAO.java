package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public List<Studente>getStudenti(int matricola)
	
	  {
		   String sql="SELECT * FROM studente WHERE matricola = ?";
		   
		   List<Studente>result= new ArrayList<Studente>();
		   try {
			   Connection conn= ConnectDB.getConnection();
				PreparedStatement st = conn.prepareStatement(sql);
				st.setInt(1,matricola); 
				ResultSet rs= st.executeQuery();
				while(rs.next())
				{
					result.add(new Studente(rs.getInt("matricola"),rs.getString("cognome"),rs.getString("nome"), rs.getString("CDS")));
				}
				conn.close();
				return result;
				
		   }
		   catch(SQLException e)
		   {
				System.err.println("ERRORE");
				e.printStackTrace();
				return null;
		   }
}
	
	public List<Studente> getStudentiByCorso (String codins) {
		String sql="SELECT s.matricola, s.cognome, s.nome, s.CDS "
				+ "FROM studente s, iscrizione i "
				+ "WHERE s.matricola = i.matricola  AND i.codins=?"; 
		List<Studente> result =new ArrayList<Studente>(); 
		
		try {
			Connection conn=ConnectDB.getConnection(); //creazione connessione
			PreparedStatement st= conn.prepareStatement(sql); //creazione statemant
			st.setString(1,codins);
			
			//esecuzione query
			ResultSet rs=st.executeQuery();
			
			while (rs.next()) { //cicla finchè c'è una riga
				//i corsi li incontriamo solo una volta --> ogni volta una new Corso con tot inscritti
				result.add(new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS"))); 
			}
			st.close();
			rs.close();
			conn.close(); 
			
			return result; 
			
		}catch(SQLException e) {
			System.err.println("Errore nel DAO"); //err stampa in rosso
			e.printStackTrace();
			return null; 
			
		}
	}
	
	public List<Studente> getStudentiCorsi (String codins){
		String sql="SELECT s.matricola, s.nome, s.cognome, s.CDS "
				+ "FROM studente s, iscrizione i "
				+ "WHERE s.matricola=i.matricola AND i.codins=? "; 
		// <> '' diverso da stringa vuota 
		
		List<Studente> result=  new ArrayList<Studente>(); 
		try {
			Connection conn=ConnectDB.getConnection(); //creazione connessione
			PreparedStatement st= conn.prepareStatement(sql); //creazione statemant
			st.setString(1,codins);
			
			//esecuzione query
			ResultSet rs=st.executeQuery();
			
			while (rs.next()) { //cicla finchè c'è una riga
				//i corsi li incontriamo solo una volta --> ogni volta una new Corso con tot inscritti
				result.add(new Studente(rs.getInt("matricola"), rs.getString("cognome"), rs.getString("nome"), rs.getString("CDS"))); 
			}
			conn.close(); 
			
			return result; 
			
		}catch(SQLException e) {
			System.err.println("Errore nel DAO"); //err stampa in rosso
			e.printStackTrace();
			return null; 
			
		}
	
	}

}
