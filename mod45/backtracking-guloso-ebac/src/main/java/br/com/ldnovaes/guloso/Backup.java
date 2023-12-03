package br.com.ldnovaes.guloso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ldnovaes
 */
public class Backup {
    
    public static class Batch {

        public int[] getFilesSize() {
            return new int[] {
                70, 20, 10
            };
        }
        
        public int getTapeSize() {
            return 100;
        }
    }
    
    public int getMinimumTapeCount(Batch batch) {
        
        int[] sizes = batch.getFilesSize();
        Arrays.sort(sizes);
        
        int tapes = 0;
        
        List<Tape> list = new ArrayList<>();
        
        for(int i = sizes.length -1; i > -1; i--) {
            boolean stored = false;
            
            for(Tape tape: list) {
                
                if(tape.getStored() + sizes[i] < batch.getTapeSize() && tape.getNumberOfFiles() < 2) {
                    tape.addStorage(sizes[i]);
                    tape.addFiles();
                    stored = true;
                    break;
                }
            }
            
            
            if(!stored) {
                list.add(new Tape(sizes[i]));
                tapes++;
            }
        }
        
        return tapes;
    }
    
    public class Tape {
        private int stored;
        private int numberOfFiles;
        
        public Tape(int stored) {
            this.stored = stored;
            this.numberOfFiles = 1;
        }
        
        public void addStorage(int storage) {
            this.stored = storage;
        }
        
        public void addFiles() {
            this.numberOfFiles++;
        }

        public int getStored() {
            return stored;
        }

        public int getNumberOfFiles() {
            return numberOfFiles;
        }
        
        
    }
    
    public static void main(String[] args) {
        Backup backup = new Backup();
        Batch batch = new Batch();
        System.out.println(backup.getMinimumTapeCount(batch));
    }
}
