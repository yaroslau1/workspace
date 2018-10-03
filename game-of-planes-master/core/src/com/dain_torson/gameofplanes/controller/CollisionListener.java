package com.dain_torson.gameofplanes.controller;


import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.dain_torson.gameofplanes.controller.objects.AmmoCrate;
import com.dain_torson.gameofplanes.controller.objects.Missile;
import com.dain_torson.gameofplanes.controller.objects.SpaceObject;
import com.dain_torson.gameofplanes.controller.objects.SpacePlane;
import com.dain_torson.gameofplanes.controller.player.Player;
import com.dain_torson.gameofplanes.data.objects.SpacePlaneData;


public class CollisionListener implements ContactListener{

    private GameStage stage;

    public CollisionListener(GameStage stage) {
        this.stage = stage;
    }

    @Override
    public void beginContact(Contact contact) {

        Body bodyA = contact.getFixtureA().getBody();
        Body bodyB = contact.getFixtureB().getBody();

        SpaceObject objectA = null;
        SpaceObject objectB = null;

        for(Actor actor : stage.getActors()) {
            if(actor instanceof SpaceObject) {
                SpaceObject object = (SpaceObject) actor;
                if(object.getBody() == bodyA) {
                    objectA = object;
                    continue;
                }
                if(object.getBody() == bodyB) {
                    objectB = object;
                }
            }
        }

        if(bodyA.isBullet() || bodyB.isBullet()) {
            objectA.setDestroyed(true);
            objectB.setDestroyed(true);
            if(objectA instanceof AmmoCrate || objectB instanceof AmmoCrate) {
                stage.setCrateSpawn(false);
            }
            else if(objectA instanceof SpacePlane) {
                Player winner = ((Missile) objectB).getCreator().getPlayer();
                Player loser = ((SpacePlane) objectA).getPlayer();
                if (loser != winner) {
                    winner.score();
                }
                loser.planeDied();

            }
            else if(objectB instanceof SpacePlane) {
                Player winner = ((Missile) objectA).getCreator().getPlayer();
                Player loser = ((SpacePlane) objectB).getPlayer();
                if (loser != winner) {
                    winner.score();
                }
                loser.planeDied();
            }
            return;
        }

       if(objectA instanceof SpacePlane && objectB instanceof AmmoCrate) {
            SpacePlane plane = (SpacePlane) objectA;
            AmmoCrate crate = (AmmoCrate) objectB;
            SpacePlaneData data = (SpacePlaneData) plane.getData();
            data.setRocketsCount(crate.getCapacity());
            objectB.setDestroyed(true);
            stage.setCrateSpawn(false);
        }

        if(objectB instanceof SpacePlane && objectA instanceof AmmoCrate) {
            SpacePlane plane = (SpacePlane) objectB;
            AmmoCrate crate = (AmmoCrate) objectA;
            SpacePlaneData data = (SpacePlaneData) plane.getData();
            data.setRocketsCount(crate.getCapacity());
            objectA.setDestroyed(true);
            stage.setCrateSpawn(false);
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
