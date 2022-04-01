package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model= new Model(); 
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> cmbCorsi;

    @FXML
    private TextField txtMatricola;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button txtV;
    
    @FXML
    private TextField txtNome;
    
    @FXML
    private TextField txtCognome;
    
    @FXML
    void iscrivi(ActionEvent event) {
    	Studente s= model.getStudenti(Integer.parseInt(txtMatricola.getText())).get(0); 
    	String corso= cmbCorsi.getValue().substring(0,8); 
    	
    	txtRisultato.setText(model.Iscrivi(s, corso));
    }

    @FXML
    void reset(ActionEvent event) {

    }

    
    @FXML
    void btnV(ActionEvent event) {
    	txtRisultato.clear();
        txtNome.clear();
        txtCognome.clear();

        int matricola= Integer.parseInt(txtMatricola.getText()); 
        String c =cmbCorsi.getValue().substring(0,8);
        
       	if(""+matricola==null || matricola==0) {
       		txtRisultato.appendText("Per favore inserisci una" +" matricola ");
       		return; 
       	}
       	
       	else {
       		for (Studente s: this.model.getStudenti(matricola)) {
       		txtNome.setText(s.getNome());
       		txtCognome.setText(s.getCognome()); 
       		}
       		
       		if(cmbCorsi.getValue().compareTo("")!=0) {
       			String result= model.isIscritto(c,matricola);
       			txtRisultato.setText(result);
       		}
       	}
       	
       	
       	
    	
    }

    @FXML
    void cercaCorsi(ActionEvent event) {
    	txtRisultato.clear();
    	
    	int matricola = Integer.parseInt(txtMatricola.getText());
    	
    	for(Corso c: model.getCorsiStudente(model.getStudenti(matricola).get(0))) {
    		txtRisultato.appendText(c.toString()+"\n");
    	}
    }

    @FXML
    void cercaIscritti(ActionEvent event) {
    	 txtRisultato.clear();
         for (Studente s: model.getStudentiCorsi(cmbCorsi.getValue().substring(0,7))) {
        	txtRisultato.appendText(s.toString()+"\n");
         }
        	
        }

   

    @FXML
    void initialize() {
        assert cmbCorsi != null : "fx:id=\"cmbCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtV != null : "fx:id=\"txtV\" was not injected: check your FXML file 'Scene.fxml'.";

        for (Corso c: model.getCorsi()) {
        	cmbCorsi.getItems().add(c.getCodins()+" "+c.getNome());
        }
        cmbCorsi.getItems().add(" "); //per creare una riga vuota nel caso non si voglia selezionare un corso
    }

	public void setModel(Model model) {
		this.model=model; 
		
	}

}
