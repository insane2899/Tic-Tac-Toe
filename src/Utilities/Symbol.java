package Utilities;

public enum Symbol {
	CROSS("X") {
		@Override
		public boolean isCross() {
			return true;
		}

		@Override
		public boolean isNought() {
			return false;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}
	},
	NOUGHT("O") {
		@Override
		public boolean isCross() {
			return false;
		}

		@Override
		public boolean isNought() {
			return true;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}
	},
	EMPTY("-") {
		@Override
		public boolean isCross() {
			return false;
		}

		@Override
		public boolean isNought() {
			return false;
		}

		@Override
		public boolean isEmpty() {
			return true;
		}
	};
	
	final String symbol;
	
	Symbol(String symbol) {
		this.symbol = symbol;
	}
	
	public abstract boolean isCross();
	public abstract boolean isNought();
	public abstract boolean isEmpty();
}
