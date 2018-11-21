package com.alis.hibernate.hw.shared;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class MyNamingStrategy extends org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
{
        @Override
        public Identifier toPhysicalTableName(Identifier name,
                                              JdbcEnvironment context) {
            return new Identifier("My_" + name.getText(), name.isQuoted());
        }

}
