package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRepositoryTest {
    private LottoRepository lottoRepository;

    @BeforeEach
    void setUp() {
        //given
        lottoRepository = new LottoRepository();
        Lotto lottoOne = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lottoTwo = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        Lotto lottoThree = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        //when
        lottoRepository.addLotto(lottoOne);
        lottoRepository.addLotto(lottoTwo);
        lottoRepository.addLotto(lottoThree);
    }

    @Test
    void 로또집합에_로또추가_테스트() {
        Lotto target = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        //then
        assertThat(lottoRepository.getAllLotto().contains(target)).isTrue();
    }

    @Test
    void 로또집합에_포함된_갯수_테스트() {
        //then
        assertThat(lottoRepository.isCheckLottoCount(3)).isTrue();
    }
}