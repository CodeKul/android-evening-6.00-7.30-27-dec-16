package com.codekul.webservices;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by aniruddha on 13/3/17.
 */

public class Q {

    private static RequestQueue q;

    public static RequestQueue q(Context context) {
        return q == null ? q = Volley.newRequestQueue(context) : q;
    }
}
