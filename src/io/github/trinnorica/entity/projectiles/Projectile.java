package io.github.trinnorica.entity.projectiles;

import io.github.trinnorica.entity.Entity;
import io.github.trinnorica.utils.Velocity;

public class Projectile extends Entity {
	
	Velocity vector;

	public Projectile(int x, int y, Velocity vec) {
		super(x, y);
		vector = vec;
	}
	
	public void updateLocation(){
		x=(int) (x+vector.x);
		y=(int) (y+vector.y);
		
	}
	
	public void updateVelocity(Velocity velocity){
		vector = velocity;
	}
	

}
