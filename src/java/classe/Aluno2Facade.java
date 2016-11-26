/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author aluno
 */
@Stateless
public class Aluno2Facade extends AbstractFacade<Aluno2> {

    @PersistenceContext(unitName = "GroupOn2.0-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Aluno2Facade() {
        super(Aluno2.class);
    }
    
}
