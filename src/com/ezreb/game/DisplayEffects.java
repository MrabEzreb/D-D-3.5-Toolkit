package com.ezreb.game;

import java.awt.Color;
import java.awt.Container;
import java.io.File;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

import testing.Main;

import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class DisplayEffects {

	public DisplayEffects() {
		BranchGroup b = new BranchGroup();
		Color3f black = new Color3f(Color.BLACK);
		Color3f red = new Color3f(Color.RED);
		String localPath = Main.class.getClassLoader().getResource("com/ezreb/game/planks_acacia.png").getPath();
		System.out.println(localPath);
		System.out.println(new File(localPath).exists());
		TextureLoader loader = new TextureLoader(localPath, "RGB", new Container());
		Texture texture = loader.getTexture();
		texture.setBoundaryModeS(Texture.WRAP);
		texture.setBoundaryModeT(Texture.WRAP);
		texture.setBoundaryColor(new Color4f(Color.BLACK));
		TextureAttributes texAttr = new TextureAttributes();
		texAttr.setTextureMode(TextureAttributes.REPLACE);
		Appearance ap = new Appearance();
		ap.setTexture(texture);
		ap.setTextureAttributes(texAttr);
		ap.setMaterial(new Material(red, black, red, black, 1.0F));
		int primflags = Primitive.GENERATE_NORMALS+Primitive.GENERATE_TEXTURE_COORDS;
		Sphere sphere = new Sphere(0.5F, primflags, ap);
		b.addChild(sphere);
		Color3f light1color = new Color3f(1.8F, 0.1F, 0.1F);
		BoundingSphere bounds = new BoundingSphere(new Point3d(0, 0, 0), 100);
		Vector3f light1Dir = new Vector3f(0.4f, -7.0f, -12.0f);
		DirectionalLight light = new DirectionalLight(light1color, light1Dir);
		light.setInfluencingBounds(bounds);
		b.addChild(light);
		AmbientLight light2 = new AmbientLight(new Color3f(0.5F, 0.5F, 0.5F));
		light2.setInfluencingBounds(bounds);
		b.addChild(light2);
		s.getViewingPlatform().setNominalViewingTransform();
		s.addBranchGraph(b);
	}
	SimpleUniverse s = new SimpleUniverse();
	public Canvas3D getCanvas() {
		return s.getCanvas();
	}
}
