package cesur.examen.domain.client;

import cesur.examen.domain.car.Car;
import cesur.examen.domain.car.CarDAO;
import lombok.extern.java.Log;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno:Samuel Leiva Álvarez
 * Fecha:11/12/23
 */



@Log
public class ClientService {

    /**
     * Return a List of Client entities that have one or more cars of the given manufacturer.
     * If a client has more than one car of the manufacturer, it only appears once in
     * the list (similar to a Set). Tip: start querying to Car entities...
     *
     * @param manufacturer
     * @return the list of clients
     */
    public static List<Client> hasManufacturer(String manufacturer){
        var out= new ArrayList<Client>(0);

        CarDAO carDAO = new CarDAO();

        /* Implement method here */
        try {
            ArrayList<Car> cars = (ArrayList<Car>) carDAO.getAllByManufacturer(manufacturer);



            for (Car c : cars) {

                out.add(c.getClient());
            }

            //Paso la salida a un HashSet para eliminar duplicados
            HashSet<Client> clientes= new HashSet<>(out);

            //vuelvo a asignarle a el arrayList salida esta vez sin duplicados
            out= new ArrayList<>(clientes);
            log.info("Clientes con almenos un coche de este fabricante buscados correctamente");

        }catch (Exception ex){

            log.severe("Problema trayendo los clientes de un fabricante");
        }

        return out;
    }
}
