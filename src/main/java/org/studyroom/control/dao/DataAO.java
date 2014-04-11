package org.studyroom.control.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 11/04/2014
 * Time: 16:36
 * To change this template use File | Settings | File Templates.
 */
public abstract class DataAO {
    private Transaction tx;

    protected void beginTransaction(Session session) {
        try {
            tx = session.beginTransaction();
        } catch (RuntimeException e) {
            System.err.println("Could Not Open Session or Begin Transaction" + e);
        }
    }

    protected void endTransaction(Session session) {
        try {
            tx.commit();
        } catch (RuntimeException e) {
            try {
                tx.rollback();
            } catch (RuntimeException rbe) {
                System.err.println("Couldn’t roll back transaction " + rbe);
            }
            throw e;
        } finally {
            tx = null;
        }
    }
}
