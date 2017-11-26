
package padma;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;


public class GridPaneTrackingController {
    
    @FXML
    void mouseEntered(MouseEvent e){
        //
        javafx.scene.Node source = (javafx.scene.Node)e.getSource() ;
        Integer colIndex = GridPane.getColumnIndex(source);
        Integer rowIndex = GridPane.getRowIndex(source);
        System.out.println(colIndex+"  "+rowIndex);
    }
    
}
