package model;

public enum Semestar {
	LETNJI("letnji"), ZIMSKI("zimski");
		
		private String naziv;
		
		Semestar(String naziv) {
			this.naziv = naziv;
		}
		
		public String getNaziv() {
			return naziv;
		}

}
