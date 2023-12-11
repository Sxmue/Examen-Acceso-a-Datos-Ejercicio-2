package cesur.examen.domain.client;

import cesur.examen.common.DAO;
import cesur.examen.common.HibernateUtil;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno:Samuel Leiva Álvarez
 * Fecha:11/12/23
 */

@Log
public class ClientDAO implements DAO<Client> {
    @Override
    public Client save(Client client) {
        return null;
    }

    @Override
    public Client update(Client client) {
        return null;
    }

    @Override
    public boolean remove(Client client) {
        return false;
    }

    @Override
    public Client get(Long id) {
        return null;
    }


    @Override
    public List<Client> getAll() {
        var out = new ArrayList<Client>();

        /* Implement method here */

        List<Client> salida = new ArrayList<>();

        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            Query<Client> q = s.createQuery("FROM Client", Client.class);

            try {
                out = (ArrayList<Client>) q.getResultList();
                log.info("Lista de clientes obtenida con exito");
            } catch (Exception e) {
                log.severe(e.getMessage());
            }
        }


        return out;
    }

}
