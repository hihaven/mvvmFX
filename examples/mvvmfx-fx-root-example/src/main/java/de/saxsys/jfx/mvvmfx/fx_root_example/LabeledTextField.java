package de.saxsys.jfx.mvvmfx.fx_root_example;

import de.saxsys.jfx.mvvm.api.FxmlView;
import de.saxsys.jfx.mvvm.api.InjectViewModel;
import de.saxsys.jfx.mvvm.viewloader.ViewLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class LabeledTextField extends HBox implements FxmlView<LabeledTextFieldViewModel>{
    
    @FXML
    private Label label;
    
    @FXML
    private TextField textField;
    
    @FXML
    private Button button;
    
    @InjectViewModel
    private LabeledTextFieldViewModel viewModel;
    
    public LabeledTextField(){
        ViewLoader viewLoader = new ViewLoader();
        
        viewLoader.setController(this);
        viewLoader.setRoot(this);
        
        viewLoader.loadViewTuple(this.getClass());
    }
    
    public void initialize(){
        label.textProperty().bind(viewModel.labelTextProperty());
        textField.textProperty().bindBidirectional(viewModel.inputTextProperty());
        
        button.disableProperty().bind(viewModel.buttonDisabledProperty());
    }
    
    @FXML
    public void onAction(){
        viewModel.changeLabel();
    }
    
    
}