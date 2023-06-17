package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class FlyingText {
    private Vector2 position;
    private Vector2 velocity;
    private StringBuilder text;
    private float time;
    private float timeMax;
    private boolean active;

    public FlyingText() {
        this.position = new Vector2(0, 0);
        this.velocity = new Vector2(0, 0);
        this.text = new StringBuilder();
        this.timeMax = 5.0f;
        this.time = 0.0f;
        this.active = false;
    }

    public Vector2 getPosition() {
        return position;
    }

    public StringBuilder getText() {
        return text;
    }

    public boolean isActive() {
        return active;
    }

    public void setup(float x, float y, StringBuilder text) {
        this.position.set(x, y);
        this.velocity.set(10, 30);
        this.text.setLength(0);
        this.text.append(text);
        this.time = 0.0f;
        this.active = true;
    }

    public void deactivate() {
        active = false;
    }

    public void update(float dt) {
        time += dt;
        position.mulAdd(velocity, dt);
        if (time > timeMax) deactivate();
    }
}
