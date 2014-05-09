package org.studyroom.control.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.studyroom.model.entity.Tag;


/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 29/04/2014
 * Time: 17:20
 * To change this template use File | Settings | File Templates.
 */
public class TagDao extends DataAO {

    private static TagDao ourInstance = new TagDao();

    private TagDao() {
    }

    public static TagDao getInstance() {
        return ourInstance;
    }

    public void addTag(Session session, Tag Tag) {
        super.beginTransaction(session);
        session.save(Tag);
        super.endTransaction(session);
    }

    public Tag getTag(Session session, String tag) {
        super.beginTransaction(session);
        Query query = session.createQuery("select tag from Tag tag where tag.tag= :yourtag");
        query.setParameter("yourtag", tag);
        super.endTransaction(session);
        return (Tag) query.uniqueResult();
    }

    public Tag getTag(Session session, long tagId) {
        super.beginTransaction(session);
        Query query = session.createQuery("select tag from Tag tag where tag.id= :yourid");
        query.setParameter("yourid", tagId);
        super.endTransaction(session);
        return ((Tag) query.uniqueResult());
    }

}
