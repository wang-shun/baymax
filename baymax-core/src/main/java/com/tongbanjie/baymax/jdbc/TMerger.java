package com.tongbanjie.baymax.jdbc;

import com.tongbanjie.baymax.jdbc.merge.MergeColumn;
import com.tongbanjie.baymax.jdbc.merge.agg.AggResultSet;
import com.tongbanjie.baymax.jdbc.merge.groupby.GroupByResultSet;
import com.tongbanjie.baymax.jdbc.merge.iterator.IteratorResutSet;
import com.tongbanjie.baymax.jdbc.merge.orderby.OrderByResultSet;
import com.tongbanjie.baymax.router.model.ExecutePlan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by sidawei on 16/1/29.
 */
public class TMerger {

    public static TResultSet mearge(ExecutePlan plan, List<ResultSet> sets, TStatement outStmt) throws SQLException {

        if (sets == null || sets.size() <= 1){
            return new IteratorResutSet(sets, outStmt);
        }

        // groupby
        // groupby + orderby
        // agg + groupby
        // agg + groupby + orderby
        List<String> groupColumns = plan.getGroupbyColumns();
        if (groupColumns != null && groupColumns.size() > 0){
            return new GroupByResultSet(sets, outStmt, plan);
        }

        // agg
        Map<String, MergeColumn.MergeType> mergeColumns = plan.getMergeColumns();
        if (mergeColumns != null && mergeColumns.size() > 0){
            return new AggResultSet(sets, outStmt, plan);
        }

        // orderby
        if (plan.getOrderbyColumns() != null && plan.getOrderbyColumns().size() > 0){
            return new OrderByResultSet(sets, outStmt, plan);
        }

        // 普通ResultSet
        return new IteratorResutSet(sets, outStmt);
    }


}