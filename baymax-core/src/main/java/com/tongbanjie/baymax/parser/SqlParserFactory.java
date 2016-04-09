package com.tongbanjie.baymax.parser;

import com.tongbanjie.baymax.parser.model.SqlType;
import com.tongbanjie.baymax.parser.mysql.MySqlDeleteParser;
import com.tongbanjie.baymax.parser.mysql.MySqlInsertParser;
import com.tongbanjie.baymax.parser.mysql.MySqlSelectParser;
import com.tongbanjie.baymax.parser.mysql.MySqlUpdateParser;

/**
 * Created by sidawei on 16/1/27.
 */
public class SqlParserFactory {

    public static SqlParser getParser(SqlType sqlType){

        if (sqlType == null)
            return null;

        switch (sqlType){
            case SELECT:
                return new MySqlSelectParser();
            case INSERT:
                return new MySqlInsertParser();
            case UPDATE:
                return new MySqlUpdateParser();
            case DELETE:
                return new MySqlDeleteParser();
            default:
                return null;
        }
    }

}
