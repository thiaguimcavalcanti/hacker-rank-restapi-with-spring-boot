package com.hackerrank.github.util;

public class Constants {

	private Constants() {
		throw new IllegalStateException("Utility class");
	}
	
	public static final String QUERY_ACTOR_GET_ACTORS_ORDERED_BY_MAXIMUM_STREAK = "WITH events_with_distinct_dates AS " +
			"(" +
			" SELECT actor_id AS actor_id, MAX(created_at) AS created_at " + 
    		"        FROM event " + 
    		"        GROUP BY actor_id, CAST(created_at AS DATE) " + 
    		") " +
    		" SELECT  a.id, " + 
    		"        a.login, " + 
    		"        a.avatar " + 
    		"    FROM ( " + 
    		"        SELECT actor_id, MAX(created_at) AS created_at, COUNT(*) AS streak " + 
    		"            FROM ( " + 
    		"                SELECT e1.actor_id, e1.created_at, DATEADD('DAY', - ( " + 
    		"                                SELECT COUNT(*) " + 
    		"                                    FROM events_with_distinct_dates e2 " + 
    		"                                    WHERE e2.actor_id = e1.actor_id " + 
    		"                                    and CAST(e2.created_at AS DATE) <= CAST(e1.created_at AS DATE) " + 
    		"                            ), CAST(e1.created_at AS DATE) " + 
    		"                        ) AS grp " + 
    		"                    FROM events_with_distinct_dates e1 " + 
    		"            ) " + 
    		"            GROUP BY actor_id, grp " + 
    		"    ) " + 
    		"    INNER JOIN actor a ON a.id = actor_id " + 
    		"    GROUP BY actor_id " + 
    		"    ORDER BY streak DESC, MAX(created_at) DESC, a.login";
	
}
