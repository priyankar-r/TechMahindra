import { extendTheme } from "@chakra-ui/react";
import { mode } from "@chakra-ui/theme-tools";
const Theme = extendTheme({
  styles: {
    global: (props: Record<string, any>) => ({
      body: {
        bg: mode("gray.100", "#121212")(props),
        color: mode("gray.900", "gray.100")(props),
      },
    }),
  },
});
export default Theme;