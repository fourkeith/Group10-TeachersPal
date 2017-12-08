package com.example.fitfourdesktop.group10_teacherspal;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by Skipper on 07/12/2017.
 */

public class MyGLSurfaceView extends GLSurfaceView {

    private final GLRenderer mRenderer;

    public MyGLSurfaceView(Context context){
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        mRenderer = new GLRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);
    }
}
