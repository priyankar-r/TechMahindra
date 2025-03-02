import {HStack, Switch, useColorMode} from "@chakra-ui/react";
function DarkSwitch(){
    let { colorMode, toggleColorMode} = useColorMode();
    return (
        <HStack>
            <Switch colorScheme ="blue" fontFamily={'monospace'} isChecked = {colorMode =='dark'} onChange={toggleColorMode}><b>Darkswitch</b></Switch>
        </HStack>
    );
}
export default DarkSwitch;