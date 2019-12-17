package sensory;

import manager.Event;
import manager.ManagerEventow;

import java.sql.SQLException;

public interface Sensor {

    public void wyslij(ManagerEventow x, int data) throws SQLException;
    
    



}
