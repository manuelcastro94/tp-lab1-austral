package org.studyroom.model;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGeneratorHelper.BigDecimalHolder;
import org.hibernate.id.IntegralDataTypeHolder;
import org.hibernate.id.SequenceGenerator;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Federico F. Favale
 * Date: 11/04/2014
 * Time: 13:51
 * To change this template use File | Settings | File Templates.
 */
public class StringSequenceGenerator extends SequenceGenerator {
    @Override
    public Serializable generate(SessionImplementor session, Object obj) {
        return super.generate(session, obj).toString();
    }

    protected IntegralDataTypeHolder buildHolder() {
        return new BigDecimalHolder();
    }
}