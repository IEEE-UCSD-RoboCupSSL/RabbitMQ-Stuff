package com.triton.util;

import java.util.Objects;

public class Vector2d {
    public final float x;
    public final float y;

    public Vector2d(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2d(Vector2d vector) {
        this.x = vector.x;
        this.y = vector.y;
    }

    public Vector2d(float angle) {
        this.x = (float) Math.cos(angle);
        this.y = (float) Math.sin(angle);
    }

    public static float angleDifference(float angle1, float angle2) {
        double diff = (angle2 - angle1 + Math.PI) % (2 * Math.PI) - Math.PI;
        return (float) (diff < -Math.PI ? diff + 2 * Math.PI : diff);
    }

    public float angle() {
        return (float) Math.atan2(y, x);
    }

    public Vector2d norm() {
        float mag = mag();
        return this.scale(1f / mag);
    }

    public float mag() {
        return (float) Math.sqrt(x * x + y * y);
    }

    public Vector2d scale(float scale) {
        return new Vector2d(x * scale, y * scale);
    }

    public Vector2d add(Vector2d vector) {
        return new Vector2d(x + vector.x, y + vector.y);
    }

    public float scalarProj(Vector2d vector) {
        return dot(vector) / vector.mag();
    }

    public float dot(Vector2d vector) {
        return x * vector.x + y * vector.y;
    }

    public Vector2d proj(Vector2d vector) {
        return vector.scale(dot(vector) / vector.dot(vector));
    }

    public float dist(Vector2d vector) {
        return sub(vector).mag();
    }

    public Vector2d sub(Vector2d vector) {
        return new Vector2d(x - vector.x, y - vector.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2d vector2d = (Vector2d) o;
        return Float.compare(vector2d.x, x) == 0 && Float.compare(vector2d.y, y) == 0;
    }

    @Override
    public String toString() {
        return "Vector2d{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
