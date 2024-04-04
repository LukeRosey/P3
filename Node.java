
public class Node {

	private boolean isLeaf = false;
	private String dna = null;
	private Integer level = null;
	private Node[] branch = null;
	
	public Node(boolean isLeaf, String dna, Integer level) {
		this.isLeaf = isLeaf;
		this.dna = dna;
		this.level = level;
	}
	
	public String insert(String dnaInput) {
		//TODO check dna string input
		//TODO check for duplicates
		
		//Case 1: Tree is empty
		if(isLeaf && (dna == null)) {
			dna = dnaInput;
			level = 0;
			return("sequence " + dna + " inserted at level " + level);
		}
		
		//Case 2: Traversal reaches a leaf node
		if(isLeaf) {
			//Split node
			branch = new Node[5];
			if(dna.charAt(0) == 'A') { //A-branch
				branch[0] = new Node(true, dna, level + 1);
			} else if(dna.charAt(0) == 'C') { //C-branch
				branch[1] = new Node(true, dna, level + 1);
			} else if(dna.charAt(0) == 'G') { //G-branch
				branch[2] = new Node(true, dna, level + 1);
			} else if(dna.charAt(0) == 'T') { //T-branch
				branch[3] = new Node(true, dna, level + 1);
			} else { //$-branch
				branch[4] = new Node(true, dna, level + 1);
			}
			
			//Change this node to be internal
			isLeaf = false;
			dna = null;
			level = null;
			
			//Call insert again
			insert(dnaInput);
		}
		
		//Case 3: Traversal reaches an internal node
		if(!isLeaf) {
			if(dnaInput.charAt(0) == 'A') {
				if(branch[0] == null) {
					branch[0] = new Node(true, dnaInput, 1);
				} else {
					branch[0].insert(dnaInput);
				}
			} else if(dnaInput.charAt(0) == 'C') {
				if(branch[1] == null) {
					branch[1] = new Node(true, dnaInput, 1);
				} else {
					branch[1].insert(dnaInput);
				}
			} else if(dnaInput.charAt(0) == 'G') {
				if(branch[2] == null) {
					branch[1] = new Node(true, dnaInput, 1);
				} else {
					branch[1].insert(dnaInput);
				}
			} else if(dnaInput.charAt(0) == 'T') {
				if(branch[3] == null) {
					branch[1] = new Node(true, dnaInput, 1);
				} else {
					branch[1].insert(dnaInput);
				}
			} else {
				if(branch[4] == null) {
					branch[4] = new Node(true, dnaInput, 1);
				} else {
					branch[4].insert(dnaInput);
				}
			}
		}
		
		return "Bad return";
	}
}
