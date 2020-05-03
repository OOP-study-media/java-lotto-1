export const validatePurchaseAmountInput = (purchaseAmount: string, lottoPrice: number) => {
  let _purchaseAmount = purchaseAmount.trim()

  if (_purchaseAmount.length === 0) {
    return 'PURCHASE_AMOUNT_IS_BLANK_ERROR'
  }

  const purchaseAmountHasString = _purchaseAmount && _purchaseAmount.match(/\D/g)
  if (purchaseAmountHasString !== null && purchaseAmountHasString.length >= 0) {
    return 'PURCHASE_AMOUNT_IS_NOT_NUMBER_ERROR'
  }
  if (_purchaseAmount.length < String(lottoPrice).length) {
    return 'PURCHASE_AMOUNT_IS_LESS_THAN_MINIMUM_AMOUNT_ERROR'
  }

  return _purchaseAmount
}

export const validateManualLottoCountInput = (manualLottoCount: string, lottoCount: number) => {
  let _manualLottoCount = manualLottoCount.trim()

  if (_manualLottoCount.length === 0) {
    return 'MANUAL_LOTTO_COUNT_IS_BLANK_ERROR'
  }

  const manualLottoCountHasString = _manualLottoCount && _manualLottoCount.match(/\D/g)
  if (manualLottoCountHasString !== null && manualLottoCountHasString.length >= 0) {
    return 'MANUAL_LOTTO_COUNT_IS_NOT_NUMBER_ERROR'
  }
  if (Number(_manualLottoCount) > lottoCount) {
    return 'MAMUAL_LOTTO_COUNT_IS_GREATER_THAN_LOTTO_COUNT_ERROR'
  }

  return _manualLottoCount
}

export const validateManualLottoNumber = (
  manualLottoNumber: string,
  LOTTO_COUNT: number,
  LOTTO_MAX_NUMBER: number,
  LOTTO_NUMBERS: number[]
) => {
  const checkDuplicationLottoNumber: boolean[] = []
  for (let i = 1; i <= LOTTO_MAX_NUMBER; i++) {
    LOTTO_NUMBERS.push(i)
    checkDuplicationLottoNumber.push(false)
  }

  let _manualLottoNumber = manualLottoNumber.split(',')
  _manualLottoNumber = _manualLottoNumber.map((lottoNumber) => lottoNumber.trim())

  if (_manualLottoNumber.length === 0) {
    return 'LOTTO_NUMBER_IS_BLANK_ERROR'
  }
  if (_manualLottoNumber.length > LOTTO_COUNT) {
    return 'LOTTO_NUMBER_IS_GREATER_THAN_LOTTO_COUNT'
  }
  if (_manualLottoNumber.length < LOTTO_COUNT) {
    return 'LOTTO_NUMBER_IS_LESS_THAN_LOTTO_COUNT'
  }

  for (let i = 0; i < _manualLottoNumber.length; i++) {
    if (_manualLottoNumber[i] === '') {
      return 'LOTTO_NUMBER_IS_BLANK_ERROR'
    }
    const lottoNumberHasString = _manualLottoNumber[i] && _manualLottoNumber[i].match(/\D/g)
    if (lottoNumberHasString !== null && lottoNumberHasString.length >= 0) {
      return 'LOTTO_NUMBER_IS_NOT_NUMBER_ERROR'
    }
    if (LOTTO_NUMBERS.indexOf(Number(_manualLottoNumber[i])) < 0) {
      return 'LOTTO_NUMBER_IS_NOT_BE_IN_LOTTO_SCOPE_ERROR'
    }
    if (checkDuplicationLottoNumber[Number(_manualLottoNumber[i])] === true) {
      return 'LOTTO_NUMBER_HAS_DUPLICATION_NUMBER_ERROR'
    }
    checkDuplicationLottoNumber[Number(_manualLottoNumber[i])] = true
  }

  return _manualLottoNumber
}

export const validateWinningLottoNumber = (
  manualLottoNumber: string,
  LOTTO_COUNT: number,
  LOTTO_MAX_NUMBER: number,
  LOTTO_NUMBERS: number[]
) => {
  const checkDuplicationLottoNumber: boolean[] = []
  for (let i = 1; i <= LOTTO_MAX_NUMBER; i++) {
    LOTTO_NUMBERS.push(i)
    checkDuplicationLottoNumber.push(false)
  }

  let _winningLottoNumber = manualLottoNumber.split(',')
  _winningLottoNumber = _winningLottoNumber.map((lottoNumber) => lottoNumber.trim())

  if (_winningLottoNumber.length === 0) {
    return 'LOTTO_NUMBER_IS_BLANK_ERROR'
  }
  if (_winningLottoNumber.length > LOTTO_COUNT - 1) {
    return 'LOTTO_NUMBER_IS_GREATER_THAN_LOTTO_COUNT'
  }
  if (_winningLottoNumber.length < LOTTO_COUNT - 1) {
    return 'LOTTO_NUMBER_IS_LESS_THAN_LOTTO_COUNT'
  }

  for (let i = 0; i < _winningLottoNumber.length; i++) {
    if (_winningLottoNumber[i] === '') {
      return 'LOTTO_NUMBER_IS_BLANK_ERROR'
    }
    const lottoNumberHasString = _winningLottoNumber[i] && _winningLottoNumber[i].match(/\D/g)
    if (lottoNumberHasString !== null && lottoNumberHasString.length >= 0) {
      return 'LOTTO_NUMBER_IS_NOT_NUMBER_ERROR'
    }
    if (LOTTO_NUMBERS.indexOf(Number(_winningLottoNumber[i])) < 0) {
      return 'LOTTO_NUMBER_IS_NOT_BE_IN_LOTTO_SCOPE_ERROR'
    }
    if (checkDuplicationLottoNumber[Number(_winningLottoNumber[i])] === true) {
      return 'LOTTO_NUMBER_HAS_DUPLICATION_NUMBER_ERROR'
    }
    checkDuplicationLottoNumber[Number(_winningLottoNumber[i])] = true
  }

  return _winningLottoNumber
}

export const validateBonusBallInput = (
  validatedWinningLottoNumber: string[],
  bonusBall: string,
  LOTTO_NUMBERS: number[]
) => {
  if (bonusBall === '') {
    return 'BONUS_BALL_IS_BLANK_ERROR'
  }
  const _bonusBall = Number(bonusBall)

  const bonusBallHasString = bonusBall.match(/\D/g)
  if (bonusBallHasString !== null && bonusBallHasString.length >= 0) {
    return 'BONUS_BALL_IS_NOT_NUMBER_ERROR'
  }
  if (LOTTO_NUMBERS.indexOf(_bonusBall) < 0) {
    return 'BONUS_BALL_IS_NOT_BE_IN_LOTTO_SCOPE_ERROR'
  }
  if (validatedWinningLottoNumber.indexOf(bonusBall) > 0) {
    return 'WINNING_LOTTO_NUMBER_HAS_BONUS_BALL_ERROR'
  }

  return bonusBall
}
