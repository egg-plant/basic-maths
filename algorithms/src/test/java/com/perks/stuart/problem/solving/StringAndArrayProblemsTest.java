package com.perks.stuart.problem.solving;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAndArrayProblemsTest {

    StringAndArrayProblems stringAndArrayProblems = new StringAndArrayProblems();

    @Test
    void duplicatesInAString() {
        assertFalse(stringAndArrayProblems.duplicatesInAString("a"));

        assertFalse(stringAndArrayProblems.duplicatesInAString("azhgesf"));

        assertTrue(stringAndArrayProblems.duplicatesInAString("afsfajlklfs"));
        assertTrue(stringAndArrayProblems.duplicatesInAString("afsfajlklfa"));

    }

    @Test
    void reverseCStyleString() {
        assertEquals("\nimoan", stringAndArrayProblems.reverseCStyleString("naomi\n"));
        assertEquals("\naaabbb", stringAndArrayProblems.reverseCStyleString("bbbaaa\n"));
    }

    @Test
    void removeDuplicatesInStringNoDataStrucutre() {
        assertEquals("abce", stringAndArrayProblems.removeDuplicatesWithoutDataStructure("abccbae"));
//        assertEquals("\naaabbb", stringAndArrayProblems.reverseCStyleString("bbbaaa\n"));
    }

    @Test
    void balancedBrackets() {
        //
//    {][({(}]][[[{}]][[[())}[)(]([[[)][[))[}[]][()}))](]){}}})}[{]{}{((}]}{{)[{[){{)[]]}))]()]})))[
//        [)](][[([]))[)
//        ]}]){[{{){
//        {[(}{)]]){(}}(][{{)]{[(((}{}{)}[({[}[}((}{()}[]})]}]]))((]][[{{}[(}})[){()}}{(}{{({{}[[]})]{((]{[){[
//        ()}}[(}])][{]{()([}[}{}[{[]{]](]][[))(()[}(}{[{}[[]([{](]{}{[){()[{[{}}{[{()(()({}([[}[}[{(]})
//        ){[])[](){[)}[)]}]]){](]()]({{)(]])(]{(}(}{)}])){[{}((){[({(()[[}](]})]}({)}{)]{{{
//        [(})])}{}}]{({[]]]))]})]
//        [{
//        {}([{()[]{{}}}])({})
//        {({}{[({({})([[]])}({}))({})]})}
//        ()[]
//        {)[])}]){){]}[(({[)[{{[((]{()[]}][([(]}{](])()(}{(]}{})[)))[](){({)][}()((
//        [][(([{}])){}]{}[()]{([[{[()]({}[])()()}[{}][]]])}
//        (}]}
//        (([{()}]))[({[{}{}[]]{}})]{((){}{()}){{}}}{}{{[{[][]([])}[()({}())()({[]}{{[[]]([])}})()]]}}
//        [(([){[](}){){]]}{}([](([[)}[)})[(()[]){})}}]][({[}])}{(({}}{{{{])({]]}[[{{(}}][{)([)]}}
//        ()()[()([{[()][]{}(){()({[]}[(((){(())}))]()){}}}])]
//        ({)}]}[}]{({))}{)]()(](])})][(]{}{({{}[]{][)){}{}))]()}((][{]{]{][{}[)}}{)()][{[{{[[
//        )}(()[])(}]{{{}[)([})]()}()]}(][}{){}}})}({](){([()({{(){{
//        }([]]][[){}}[[)}[(}(}]{(}[{}][{}](}]}))]{][[}(({(]}[]{[{){{(}}[){[][{[]{[}}[)]}}]{}}(}

        //    YES
//            NO
//    NO
//            NO
//    NO
//            NO
//    NO
//            NO
//    NO
//            YES
//    YES
//            YES
//    NO
//            YES
//    NO
//            YES
//    NO
//            YES
//    NO
//            NO
//    NO
        assertEquals("YES", stringAndArrayProblems.balancedBrackets("()[{}()]([[][]()[[]]]{()})([]()){[]{}}{{}}{}(){([[{}([]{})]])}"));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets("[)](][[([]))[)"));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets("]}]){[{{){"));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets("{[(}{)]]){(}}(][{{)]{[(((}{}{)}[({[}[}((}{()}[]})]}]]))((]][[{{}[(}})[){()}}{(}{{({{}[[]})]{((]{[){["));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets("()}}[(}])][{]{()([}[}{}[{[]{]](]][[))(()[}(}{[{}[[]([{](]{}{[){()[{[{}}{[{()(()({}([[}[}[{(]})"));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets("){[])[](){[)}[)]}]]){](]()]({{)(]])(]{(}(}{)}])){[{}((){[({(()[[}](]})]}({)}{)]{{{"));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets("[(})])}{}}]{({[]]]))]})]"));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets("[{"));
        assertEquals("YES", stringAndArrayProblems.balancedBrackets("{}([{()[]{{}}}])({})"));
        assertEquals("YES", stringAndArrayProblems.balancedBrackets("{}([{()[]{{}}}])({})"));
        assertEquals("YES", stringAndArrayProblems.balancedBrackets("{({}{[({({})([[]])}({}))({})]})}"));
        assertEquals("YES", stringAndArrayProblems.balancedBrackets("()[]"));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets("{)[])}]){){]}[(({[)[{{[((]{()[]}][([(]}{](])()(}{(]}{})[)))[](){({)][}()(("));
        assertEquals("YES", stringAndArrayProblems.balancedBrackets("[][(([{}])){}]{}[()]{([[{[()]({}[])()()}[{}][]]])}"));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets("(}]}"));
        assertEquals("YES", stringAndArrayProblems.balancedBrackets("(([{()}]))[({[{}{}[]]{}})]{((){}{()}){{}}}{}{{[{[][]([])}[()({}())()({[]}{{[[]]([])}})()]]}}"));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets("[(([){[](}){){]]}{}([](([[)}[)})[(()[]){})}}]][({[}])}{(({}}{{{{])({]]}[[{{(}}][{)([)]}}"));
        assertEquals("YES", stringAndArrayProblems.balancedBrackets("()()[()([{[()][]{}(){()({[]}[(((){(())}))]()){}}}])]"));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets("({)}]}[}]{({))}{)]()(](])})][(]{}{({{}[]{][)){}{}))]()}((][{]{]{][{}[)}}{)()][{[{{[["));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets(")}(()[])(}]{{{}[)([})]()}()]}(][}{){}}})}({](){([()({{(){{"));
        assertEquals("NO", stringAndArrayProblems.balancedBrackets("}([]]][[){}}[[)}[(}(}]{(}[{}][{}](}]}))]{][[}(({(]}[]{[{){{(}}[){[][{[]{[}}[)]}}]{}}(}"));

    }

    @Test
    public void contacts() {
        assertArrayEquals(new int[]{2, 0}, stringAndArrayProblems.contacts(new String[][]{{"add", "hack"}, {"add", "hackerrank"}, {"find", "hac"}, {"find", "hak"}}));
        assertArrayEquals(new int[]{2, 1}, stringAndArrayProblems.contacts(new String[][]{{"add", "dad"}, {"add", "daddy"}, {"find", "da"}, {"find", "daddy"}}));
    }
}