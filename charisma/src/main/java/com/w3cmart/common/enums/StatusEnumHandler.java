package com.w3cmart.common.enums;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StatusEnumHandler
        implements TypeHandler
{
    static Logger logger = LoggerFactory.getLogger(StatusEnumHandler.class);

    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        StatusEnum en = (StatusEnum)parameter;
        if (jdbcType == null)
            ps.setInt(i, en.value);
        else
            ps.setObject(i, (byte) en.value, jdbcType.TYPE_CODE);
    }

    public StatusEnum getResult(ResultSet rs, String columnName)
            throws SQLException
    {
        return StatusEnum.DISABLE.getEnumInstance(rs.getByte(columnName));
    }

    public StatusEnum getResult(CallableStatement cs, int columnIndex) throws SQLException
    {
        return StatusEnum.DISABLE.getEnumInstance(cs.getByte(columnIndex));
    }

    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }
}