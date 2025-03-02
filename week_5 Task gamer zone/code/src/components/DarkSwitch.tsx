import { HStack, Switch, useColorMode, Text } from "@chakra-ui/react";
function DarkSwitch() {
  let { colorMode, toggleColorMode } = useColorMode();
  return (
    <HStack cursor="pointer" _hover={{ transform: "scale(1.1)", transition: "0.2s" }}>
      <Text fontWeight="bold">{colorMode === "dark" ? "🌙" : "☀️"}</Text>
      <Switch colorScheme="blue" isChecked={colorMode === "dark"} onChange={toggleColorMode} />
    </HStack>
  );
}
export default DarkSwitch;