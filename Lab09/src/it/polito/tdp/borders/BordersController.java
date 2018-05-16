/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import it.polito.tdp.borders.model.gradoStato;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class BordersController  {

	Model model;
	boolean flag=false;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader
	
    @FXML // fx:id="cmbStato"
    private ComboBox<Country> cmbStato; // Value injected by FXMLLoader
    @FXML // fx:id="btnVicini"
    private Button btnVicini; // Value injected by FXMLLoader
    

	@FXML
	void doCalcolaConfini(ActionEvent event) {
		txtResult.clear();
		int anno=0;
		String input;
		input=txtAnno.getText();
		try {
			
			anno=Integer.parseInt(input);
			
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Inserire un numero");
			txtResult.setText("Inserire un anno valido");
			return;
		}
		if (anno<1816 || anno>2016) {
			txtResult.setText("Inserire un anno valido");
			return;
		}
		else {
			String output="";
			List <gradoStato> lista;
			lista=model.calcolaConfini(anno);
			for (gradoStato g:lista) {
				output+=(g.getStato()+" "+g.getGrado()+"\n");
			}
			txtResult.setText(output);
			txtResult.appendText("Numero di componenti connesse: "+model.getConnessi());
			flag=true;
			
		}
		
	}
	

    @FXML
    void doVicini(ActionEvent event) {
    	txtResult.clear();
    	List <Country> vicini;
    	Set<Country> viciniRec;
    	String output="";
    	Country c=cmbStato.getValue();
    	if (c==null) {
    		txtResult.setText("Selezionare uno stato");
    	}
    	if (flag==false) {
    		txtResult.setText("Fare doCalcolaConfini!");
    	}
    	//vicini=model.trovaVicini(c);
    	viciniRec=model.trovaViciniRecursive(c);
    for (Country cy:viciniRec) {
    	output+=cy.getStateName()+"\n";
    }
    txtResult.setText(output);

    }
    
    

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
		assert cmbStato != null : "fx:id=\"cmbStato\" was not injected: check your FXML file 'Borders.fxml'.";
        assert btnVicini != null : "fx:id=\"btnVicini\" was not injected: check your FXML file 'Borders.fxml'.";
	}

	public void setModel(Model model2) {
		this.model=model2;
		cmbStato.getItems().addAll(model.getStati());
		
	}



	
}
