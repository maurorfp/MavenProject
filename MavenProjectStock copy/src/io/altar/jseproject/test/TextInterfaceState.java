package io.altar.jseproject.test;

import io.altar.jseproject.states.*;

public class TextInterfaceState {
			
//estados e matriz de transica
			
			private State[] states = { 
					new MenuInit(), 		// 0
					new MenuProducts(), 	// 1
					new ProductAdd(),		// 2
					new ProdutcEdit(),		// 3
					new ViewProducts(),		// 4
					new ProductDelete(),	// 5
					new MenuShelf(), 		// 6
					new ShelfAdd(),			// 7
					new ShelfEdit(),		// 8
					new ShelfView(),		// 9
					new ShelfDelete(),		// 10	
					
					
					
			}; 
			// 4. transitions
			private int[][] transition = { 
					{ 1, 6 }, 				// State 0 1)lista produtors 2) ??
					{ 2, 3, 4, 5,0 }, 		// State 1
					{1},					// State 2
					{1},					// State 3
					{1},   					// State 4
					{1},					// State 5
					{7,8,9,10,0},			// State 6
					{6},					// State 7
					{6},					// State 8
					{6},					// State 9
					{6},					// State 10
					
						
			};
			// 3. current
			private int current = 0;

			public void start() {
				
				while(true) {
					int option = states[current].run();
					if (current == 0 && option == 3) {
						System.out.println("Saida");
						break;
					}
					current = transition[current][option-1];
				}
			}
	}


