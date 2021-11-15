package dtos;

public class DataDTO {
    private JokeDTO2 data;

    public DataDTO(JokeDTO2 data) {
        this.data = data;
    }

    public JokeDTO2 getData() {
        return data;
    }

    public void setData(JokeDTO2 data) {
        this.data = data;
    }
}
