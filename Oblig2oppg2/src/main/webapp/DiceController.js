class DiceController {
	
 	#dice
 	#rootElement
 	/**
	 * @param {String} rootId
	 * 
	 */

		
   		constructor(rootId) {
			console.log("hei")
			const root = document.getElementById(rootId);
			this.#rootElement = root;
			const dicebutton = root.querySelector("*[data-dicebutton]");
			if(dicebutton){
				this.#dice = new Dice();
				dicebutton.addEventListener("click",this.rollDice.bind(this));
			}
			else{
				console.error("ingen knapp");
			}
		}
		
		rollDice(){
			console.log("hei")
			this.#dice.roll();
			const element = this.#rootElement.querySelector("*[data-diceoutput]");
			if(element){
				element.innerText = this.#dice.getValue();
			}else{
				console.error("ingen value");
			}
		}
	}
	
	
	document.addEventListener("DOMcontentLoaded",()=> new DiceController("root"));

	

	
