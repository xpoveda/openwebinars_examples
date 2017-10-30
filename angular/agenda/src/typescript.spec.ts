// launch with ng test and open the webpage

describe('typescript tests', () => {

  const _ = '';

  it('true is true', () => expect(true).toEqual(true));

  it('null is not the same thing as undefined',
    () => expect(null).not.toEqual(undefined)
  );

  it('template strings allow ${variables}',
    () => {
      const hola = 'nhpatt';
      expect(`hola, ${hola}!`).toEqual('hola, _!');
    }
  );

  it('let are equals to var with block support',
    () => {

      {
        // noinspection TsLint
        var hola = 'hi!';
        expect(hola).toEqual(_);
      }
      expect(hola).toEqual(_);

      {
        const adios = 'hi!';
        expect(adios).toEqual(_);
      }
      // expect(adios).toEqual(_);
    }
  );

  it('fat arrows have implicit returns',
    () => {

      const fun = x => x + 1;
      const add = function (x) {
        return x + 1;
      };

      expect(fun(2)).toEqual(add(_));
    }
  );

  it('for of is great for iterables',
    () => {

      const iterable = [3, 5, 7];
      iterable['foo'] = 'hello';

      let for_props = 0;
      let for_of_props = 0;

      // noinspection TsLint
      for (const prop in iterable) {
        for_props++;
      }

      for (const prop of iterable) {
        for_of_props++;
      }

      expect(for_props).toEqual(_);
      expect(for_of_props).toEqual(_);
    }
  );

  it('we have sets now',
    () => {

      const example = new Set([2, 2, 3]);

      expect(example.size).toEqual(_);
    }
  );

  it('short syntax for objs',
    () => {

      function createMonster(name, power) {
        return {name, power};
      }

      expect(createMonster('Soraya', 1000)).toEqual(_);
    }
  );

  it('rest syntax',
    () => {

      function createMonster(name, power, ...rest) {
        return rest;
      }

      expect(createMonster('Soraya', 1000, 'tordesillas', 'toros')).toEqual(_);
    }
  );

  it('spread syntax',
    () => {

      function createMonster(name?: string, power?: number) {
        return {name, power};
      }

      const values: any[] = ['Soraya', 1000];

      expect(createMonster(...values)).toEqual(_);
    }
  );

  it('destructuring',
    () => {

      const {name, power} = {name: 'Soraya', power: 1000};

      expect(name).toEqual(_);
    }
  );

  it('destructuring with arrays',
    () => {

      let x = 1, y = 2;
      [x, y] = [y, x];

      expect(x).toEqual(_);
    }
  );

  it('union types',
    () => {

      const type: 'North' | 'East' = 'North';
      expect(type).toEqual(_);
    }
  );

  it('accessors',
    () => {

      class Example {
        private _value: number;

        set value(valor) {
          this._value = valor + 1;
        }

        get value() {
          return this._value;
        }
      }

      const ex = new Example();
      ex.value = 5;

      expect(ex.value).toEqual(_);
    }
  );

  it('function types',
    () => {

      interface Example {
        (x: number): number;

        (y: string): string;
      }

      let fun: Example;

      fun = x => x + 1;

      expect(typeof fun(1)).toEqual(_);
    }
  );

  it('static methods',
    () => {

      class Calculator {

        static add(x) {
          return x + 1;
        }
      }

      expect(Calculator.add(1)).toEqual(_);
    }
  );

});
