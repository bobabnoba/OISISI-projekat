package model;

public enum Semestar {
	LJETNJI("ljetnji"), ZIMSKI("zimski");
		
		private String naziv;
		
		Semestar(String naziv) {
			this.naziv = naziv;
		}
		
		public String getNaziv() {
			return naziv;
		}

}
