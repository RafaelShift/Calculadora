package calculatorControl.view;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class CalculatorControl{

	private Boolean digito = false;
	private Boolean punto = false;
	private int totalOperandos;
	private double operador1 =0.0;
	private double operador2 =0.0;
	private char operador;

	@FXML
	private AnchorPane anchorPaneRoot;

	@FXML
	private TextField txtEntrada;

	@FXML
	private Button btnOcho = new Button("8");

	public boolean validar(String numeros) {
		return numeros.matches("([0-9]*)?");
	}

	@FXML
	public void buttonCero(ActionEvent event) {
		digitHandlePantalla("0");
	}

	@FXML
	public void buttonUno(ActionEvent event) {
		digitHandlePantalla("1");
	}

	@FXML
	public void buttonDos(ActionEvent event) {
		digitHandlePantalla("2");
	}

	@FXML
	public void buttonTres(ActionEvent event) {
		digitHandlePantalla("3");
	}

	@FXML
	public void buttonCuatro(ActionEvent event) {
		digitHandlePantalla("4");
	}

	@FXML
	public void buttonCinco(ActionEvent event) {
		digitHandlePantalla("5");
	}

	@FXML
	public void buttonSeis(ActionEvent event) {
		digitHandlePantalla("6");
	}

	@FXML
	public void buttonSiete(ActionEvent event) {
		digitHandlePantalla("7");
	}

	@FXML
	public void buttonOcho(ActionEvent event) {
		digitHandlePantalla("8");
	}


	@FXML
	public void buttonNueve(ActionEvent event) {
		digitHandlePantalla("9");
	}

	@FXML
	public void buttonHandleResta(ActionEvent event) {
	        	evaluateOperator("-");
	}

	@FXML
	public void buttonHandleSuma(ActionEvent event) {
	        	evaluateOperator("+");
	  
	}

	@FXML
	public void buttonHandleMultiplicacion(ActionEvent event) {
	        	evaluateOperator("*");
	}

	@FXML
	public void buttonHandleDivision(ActionEvent event) {
	        	evaluateOperator("/");
	}

	@FXML
	public void buttonHandleIgual(ActionEvent event) {
		evaluateOperator("=");
	}

	@FXML
	public void buttonHandleAceptar(ActionEvent event) {
		evaluateOperator("=");
	}

	@FXML
	public void buttonHandleRetroceso(ActionEvent event) {
		if(txtEntrada.getText().length()!=0 && digito){
			txtEntrada.setText(txtEntrada.getText().substring(0, txtEntrada.getText().length()-1));
		}
	}

	@FXML
	public void buttonHandleCancel(ActionEvent event) {
		System.exit(0);
	}


	@FXML
	public void buttonHandleCe(ActionEvent event) {
		digito = false;
		totalOperandos = 0;
		operador1 = 0;
		operador2 = 0;
		operador= ' ';
		txtEntrada.setText("");
	}

	@FXML
	public void buttonHandleC(ActionEvent event) {
		digito = false;
		totalOperandos = 0;
		operador1 = 0;
		operador2 = 0;
		operador= ' ';
		txtEntrada.setText("");
	}

	@FXML
	public void buttonHandleMinus(ActionEvent event) {
		if(digito) {
			double valueActual;
			valueActual=-Float.valueOf(txtEntrada.getText());
			txtEntrada.setText(String.valueOf(valueActual));
		}
	}

	@FXML
	public void buttonHandlePunto(ActionEvent event) {
		if(!txtEntrada.getText().contains("."))
			txtEntrada.setText(txtEntrada.getText() + ".");
		punto = true;
	}

	private void digitHandlePantalla(String numero) {
		if(!digito && numero.equals("0"))
			return;
		if(!digito)
			txtEntrada.setText(" ");
		punto = false;
		String valueActual = txtEntrada.getText();
		txtEntrada.setText(valueActual + numero);
		digito = true;
	}

	@FXML
	private void initialize() {

		this.anchorPaneRoot.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {

				if(event.getCode().equals(KeyCode.BACK_SPACE)) {
					buttonHandleRetroceso(null);
				}

				else if (event.getCode().equals(KeyCode.DIGIT0) || event.getCode().equals(KeyCode.NUMPAD0))
				{
					digitHandlePantalla("0");
				}
				else if(event.getCode().equals(KeyCode.DIGIT1) || event.getCode().equals(KeyCode.NUMPAD1)) {
					digitHandlePantalla("1");
				}
				else if(event.getCode().equals(KeyCode.DIGIT2) || event.getCode().equals(KeyCode.NUMPAD2)) {
					digitHandlePantalla("2");
				}
				else if(event.getCode().equals(KeyCode.DIGIT3) || event.getCode().equals(KeyCode.NUMPAD3)) {
					digitHandlePantalla("3");
				}
				else if(event.getCode().equals(KeyCode.DIGIT4) || event.getCode().equals(KeyCode.NUMPAD4)) {
					digitHandlePantalla("4");
				}
				else if(event.getCode().equals(KeyCode.DIGIT5) || event.getCode().equals(KeyCode.NUMPAD5)) {
					digitHandlePantalla("5");
				}
				else if(event.getCode().equals(KeyCode.DIGIT6) || event.getCode().equals(KeyCode.NUMPAD6)) {
					digitHandlePantalla("6");
				}
				else if(!(event.isShiftDown()) && event.getCode().equals(KeyCode.DIGIT7) || event.getCode().equals(KeyCode.NUMPAD7)) {
					digitHandlePantalla("7");
				}

				else if (event.getCode().equals(KeyCode.DIGIT8) || event.getCode().equals(KeyCode.NUMPAD8)){
					digitHandlePantalla("8");
				}

				else if(event.getCode().equals(KeyCode.DIGIT9) || event.getCode().equals(KeyCode.NUMPAD9)) {
					digitHandlePantalla("9");
				}

				else if (event.getCode().equals(KeyCode.DECIMAL) || event.getCode().equals(KeyCode.PERIOD)){
					if(!txtEntrada.getText().contains("."))
						txtEntrada.setText(txtEntrada.getText() + ".");
					punto = true;
				}

				else if(!(event.isShiftDown()) && event.getCode().equals(KeyCode.PLUS) || event.getCode().equals(KeyCode.ADD)) {
					evaluateOperator("+");
				}

				else if(event.getCode().equals(KeyCode.MINUS) || event.getCode().equals(KeyCode.SUBTRACT)) {
					evaluateOperator("-");
				}

				else if(event.isShiftDown() && event.getCode().equals(KeyCode.PLUS) || event.getCode().equals(KeyCode.MULTIPLY)) {
					evaluateOperator("*");
				}

				else if(event.isShiftDown() && event.getCode().equals(KeyCode.DIGIT7) || event.getCode().equals(KeyCode.DIVIDE)) {
					evaluateOperator("/");
				}


				else if(event.getCode().equals(KeyCode.ENTER)) {
					evaluateOperator("=");
				}

				else {

					System.out.println(event.getCode().getName());
				}

			}


		});
	}

	private void evaluateOperator(String operador) {
		if(digito) 
			totalOperandos++;
		System.out.println(operador);
		if(totalOperandos == 1) 
			operador1 = Double.parseDouble(txtEntrada.getText());		
		if(totalOperandos == 2) {
			operador2 = Double.parseDouble(txtEntrada.getText());
			switch (this.operador) {
			case '+':
				operador1 = operador1 + operador2;
				break;

			case '-':
				operador1 = operador1 - operador2;
				break;

			case '*':
				operador1 = operador1 * operador2;
				break;

			case '/':
				operador1 = operador1 / operador2;
				break;

			case '=':
				operador1 = operador2;
				break;
			default:
				txtEntrada.setText("Valor no Admitido");
				break;
			}

			txtEntrada.setText(String.valueOf(operador1));
			totalOperandos =  1;

		}
		digito = false;
		this.operador = operador.charAt(0);
	}

}