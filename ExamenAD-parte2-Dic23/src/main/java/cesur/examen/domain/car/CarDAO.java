package cesur.examen.domain.car;

import cesur.examen.common.DAO;
import cesur.examen.common.HibernateUtil;
import cesur.examen.domain.client.Client;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno:Samuel Leiva Álvarez
 * Fecha:11/12/2023
 */

@Log
public class CarDAO implements DAO<Car> {
    @Override
    public Car save(Car car) {

        /* Implement method here */

        Car salida = null;

        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = s.beginTransaction();

            s.persist(car);

            salida = car;

            t.commit();

            log.info("Guardado correctamente: " + salida);

        } catch (Exception e) {
            log.severe(e.getMessage());
        }

        return car;
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public Car get(Long id) {
        return null;
    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    public List<Car> getAllByManufacturer(String manufacturer){
        var out = new ArrayList<Car>();


        /* Implement method here */


        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query<Car> q = s.createQuery("FROM Car where manufacturer=:manu", Car.class);

            q.setParameter("manu",manufacturer);

                out = (ArrayList<Car>) q.getResultList();

                log.info("Lista de coches por fabricante obtenida con exito");

        }catch (Exception e) {
            log.severe(e.getMessage());
            log.severe("ERROR al obtener la lista de coches por fabricante");
        }

        return out;
    }



}
