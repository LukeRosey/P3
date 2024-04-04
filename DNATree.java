
public class DNATree {

	private Node root = new Node(true, null, 0); 
	
    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.err.println("Usage: java DNAtree {command-file}");
//            return;
//        }
//
//        String commandFile = args[0];
        DNATree dnaTree = new DNATree();
        dnaTree.insert("ACGT");
        dnaTree.insert("CGT");
//        DNATree.processInputFile(commandFile);
    }

    public void insert(String dna) {
    	System.out.println(root.insert(dna));
    }

}
