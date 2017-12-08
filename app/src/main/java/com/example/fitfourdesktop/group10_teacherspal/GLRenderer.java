package com.example.fitfourdesktop.group10_teacherspal;

import android.opengl.EGLConfig;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Skipper on 07/12/2017.
 */

public class GLRenderer implements GLSurfaceView.Renderer {
    private Triangle shapeTri;
    //private Square shapeSqu;
    //private Circle shapeCir;

    public void onSurfaceCreated(GL10 unused, EGLConfig config) {
        //Set the background frame color
        GLES20.glClearColor(0.0f, 0.0f,0.0f,1.0f);
    }

    public void onDrawFrame(GL10 unused) {
        // Redraw background color
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public void onSurfaceCreated(GL10 gl10, javax.microedition.khronos.egl.EGLConfig eglConfig) {

    }

    public void onSurfaceChanged(GL10 unused, int width, int height) {
        GLES20.glViewport(0, 0, width, height);
    }
}
