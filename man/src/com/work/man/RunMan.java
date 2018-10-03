package com.work.man;

import java.util.ArrayList;
import java.util.List;

import com.work.man.jacket.AdidasJacket;
import com.work.man.jacket.PumaJacket;
import com.work.man.pants.AdidasPants;
import com.work.man.pants.PumaPants;
import com.work.man.shoes.AdidasShoes;
import com.work.man.shoes.PumaShoes;

public class RunMan {

	public static void main(String[] args) {
		
		AdidasJacket adidasJacket = new AdidasJacket();
		PumaJacket pumaJacket = new PumaJacket();
		
		AdidasPants adidasPants = new AdidasPants();
		PumaPants pumaPants = new PumaPants();
		
		AdidasShoes adidasShoes = new AdidasShoes();
		PumaShoes pumaShoes = new PumaShoes();
		
		Man nick = new Man("Nick", adidasJacket, pumaPants, adidasShoes);
		
		nick.dressed();
		nick.undressed();

	}

}
